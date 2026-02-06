#!/usr/bin/env node

const StepsTracker = require('./tracker');

/**
 * CLI interface for Steps Tracker
 */
class CLI {
  constructor() {
    this.tracker = new StepsTracker();
  }

  /**
   * Display help information
   */
  showHelp() {
    console.log(`
Steps Tracker - A simple CLI for tracking steps and tasks

USAGE:
  node src/cli.js <command> [arguments]

COMMANDS:
  init [name]              Initialize a new project
  add <description>        Add a new step
  list [filter]           List steps (all|pending|completed)
  complete <id>           Mark a step as complete
  uncomplete <id>         Mark a step as incomplete
  remove <id>             Remove a step
  clear                   Clear all completed steps
  status                  Show project status
  help                    Show this help message

EXAMPLES:
  node src/cli.js init "My Project"
  node src/cli.js add "Complete task 1"
  node src/cli.js list
  node src/cli.js complete 1
  node src/cli.js status
    `);
  }

  /**
   * Format a step for display
   */
  formatStep(step) {
    const status = step.completed ? '✓' : ' ';
    const date = step.completed 
      ? ` (completed: ${new Date(step.completedAt).toLocaleDateString()})`
      : '';
    return `[${status}] ${step.id}. ${step.description}${date}`;
  }

  /**
   * Initialize command
   */
  cmdInit(args) {
    const projectName = args.join(' ') || 'My Project';
    this.tracker.init(projectName);
    console.log(`✓ Initialized project: "${projectName}"`);
  }

  /**
   * Add command
   */
  cmdAdd(args) {
    if (args.length === 0) {
      console.error('Error: Step description is required');
      console.log('Usage: node src/cli.js add <description>');
      return;
    }

    if (!this.tracker.isInitialized()) {
      console.log('No project found. Initializing...');
      this.tracker.init();
    }

    const description = args.join(' ');
    const step = this.tracker.addStep(description);
    console.log(`✓ Added step ${step.id}: "${step.description}"`);
  }

  /**
   * List command
   */
  cmdList(args) {
    if (!this.tracker.isInitialized()) {
      console.log('No project found. Run "init" first.');
      return;
    }

    const filter = args[0] || 'all';
    const steps = this.tracker.listSteps(filter);

    if (steps.length === 0) {
      console.log(`No ${filter !== 'all' ? filter : ''} steps found.`);
      return;
    }

    console.log(`\n${this.tracker.data.project}`);
    console.log('='.repeat(this.tracker.data.project.length));
    steps.forEach(step => {
      console.log(this.formatStep(step));
    });
    console.log('');
  }

  /**
   * Complete command
   */
  cmdComplete(args) {
    if (args.length === 0) {
      console.error('Error: Step ID is required');
      console.log('Usage: node src/cli.js complete <id>');
      return;
    }

    const id = parseInt(args[0]);
    if (isNaN(id)) {
      console.error('Error: Step ID must be a number');
      return;
    }

    try {
      const step = this.tracker.completeStep(id);
      console.log(`✓ Completed step ${id}: "${step.description}"`);
    } catch (error) {
      console.error(`Error: ${error.message}`);
    }
  }

  /**
   * Uncomplete command
   */
  cmdUncomplete(args) {
    if (args.length === 0) {
      console.error('Error: Step ID is required');
      console.log('Usage: node src/cli.js uncomplete <id>');
      return;
    }

    const id = parseInt(args[0]);
    if (isNaN(id)) {
      console.error('Error: Step ID must be a number');
      return;
    }

    try {
      const step = this.tracker.uncompleteStep(id);
      console.log(`✓ Uncompleted step ${id}: "${step.description}"`);
    } catch (error) {
      console.error(`Error: ${error.message}`);
    }
  }

  /**
   * Remove command
   */
  cmdRemove(args) {
    if (args.length === 0) {
      console.error('Error: Step ID is required');
      console.log('Usage: node src/cli.js remove <id>');
      return;
    }

    const id = parseInt(args[0]);
    if (isNaN(id)) {
      console.error('Error: Step ID must be a number');
      return;
    }

    try {
      const step = this.tracker.removeStep(id);
      console.log(`✓ Removed step ${id}: "${step.description}"`);
    } catch (error) {
      console.error(`Error: ${error.message}`);
    }
  }

  /**
   * Clear command
   */
  cmdClear() {
    const removed = this.tracker.clearCompleted();
    console.log(`✓ Cleared ${removed} completed step${removed !== 1 ? 's' : ''}`);
  }

  /**
   * Status command
   */
  cmdStatus() {
    if (!this.tracker.isInitialized()) {
      console.log('No project found. Run "init" first.');
      return;
    }

    const status = this.tracker.getStatus();
    console.log(`\nProject: ${status.project}`);
    console.log('─'.repeat(40));
    console.log(`Total steps:     ${status.total}`);
    console.log(`Completed:       ${status.completed}`);
    console.log(`Pending:         ${status.pending}`);
    console.log(`Progress:        ${status.percentage}%`);
    console.log('─'.repeat(40));
    
    // Progress bar
    const barLength = 30;
    const filled = Math.round((status.percentage / 100) * barLength);
    const empty = barLength - filled;
    const bar = '█'.repeat(filled) + '░'.repeat(empty);
    console.log(`[${bar}] ${status.percentage}%\n`);
  }

  /**
   * Run CLI with provided arguments
   */
  run(args) {
    if (args.length === 0) {
      this.showHelp();
      return;
    }

    const command = args[0].toLowerCase();
    const commandArgs = args.slice(1);

    switch (command) {
      case 'init':
        this.cmdInit(commandArgs);
        break;
      case 'add':
        this.cmdAdd(commandArgs);
        break;
      case 'list':
        this.cmdList(commandArgs);
        break;
      case 'complete':
        this.cmdComplete(commandArgs);
        break;
      case 'uncomplete':
        this.cmdUncomplete(commandArgs);
        break;
      case 'remove':
        this.cmdRemove(commandArgs);
        break;
      case 'clear':
        this.cmdClear();
        break;
      case 'status':
        this.cmdStatus();
        break;
      case 'help':
      case '--help':
      case '-h':
        this.showHelp();
        break;
      default:
        console.error(`Unknown command: ${command}`);
        console.log('Run "node src/cli.js help" for usage information');
    }
  }
}

// Run CLI if this is the main module
if (require.main === module) {
  const cli = new CLI();
  const args = process.argv.slice(2);
  cli.run(args);
}

module.exports = CLI;
