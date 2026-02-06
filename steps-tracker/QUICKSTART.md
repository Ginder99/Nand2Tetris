# Quick Start Guide

Get started with Steps Tracker in 2 minutes!

## Installation

```bash
cd steps-tracker
# No dependencies needed - pure Node.js!
```

## Your First Steps

### 1. Create Your First Project (5 seconds)

```bash
node src/cli.js init "My Daily Goals"
```
Output: `✓ Initialized project: "My Daily Goals"`

### 2. Add Some Steps (10 seconds)

```bash
node src/cli.js add "Morning workout"
node src/cli.js add "Read 30 pages"
node src/cli.js add "Write blog post"
```

### 3. See Your Steps (5 seconds)

```bash
node src/cli.js list
```

You'll see:
```
My Daily Goals
==============
[ ] 1. Morning workout
[ ] 2. Read 30 pages
[ ] 3. Write blog post
```

### 4. Complete a Step (5 seconds)

```bash
node src/cli.js complete 1
```
Output: `✓ Completed step 1: "Morning workout"`

### 5. Check Your Progress (5 seconds)

```bash
node src/cli.js status
```

See your progress bar:
```
Project: My Daily Goals
────────────────────────────────────────
Total steps:     3
Completed:       1
Pending:         2
Progress:        33%
────────────────────────────────────────
[██████████░░░░░░░░░░░░░░░░░░░░] 33%
```

## That's It! 🎉

You're now tracking your steps!

## Common Workflows

### Daily Task List
```bash
node src/cli.js init "Today's Tasks"
node src/cli.js add "Check emails"
node src/cli.js add "Team meeting"
node src/cli.js add "Deploy v2.0"
# Complete as you go...
node src/cli.js complete 1
node src/cli.js complete 2
# Clear at end of day
node src/cli.js clear
```

### Learning Path
```bash
node src/cli.js init "Learn React"
node src/cli.js add "Components & Props"
node src/cli.js add "State & Lifecycle"
node src/cli.js add "Hooks"
node src/cli.js add "Build a project"
```

### Project Milestones
```bash
node src/cli.js init "Website Redesign"
node src/cli.js add "Research competitors"
node src/cli.js add "Create mockups"
node src/cli.js add "Get feedback"
node src/cli.js add "Implement design"
node src/cli.js add "Launch!"
```

## Pro Tips

💡 **Tip 1**: View only pending tasks with `node src/cli.js list pending`

💡 **Tip 2**: Use descriptive step names for better clarity

💡 **Tip 3**: Run `status` regularly for motivation!

💡 **Tip 4**: Use `clear` to remove old completed steps

💡 **Tip 5**: Made a mistake? Use `uncomplete <id>` to revert

## Need Help?

Run `node src/cli.js help` anytime!

---

Happy tracking! Start building your productivity today! 🚀
