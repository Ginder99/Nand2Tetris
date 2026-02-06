const Storage = require('./storage');

/**
 * StepsTracker - Core logic for managing steps
 */
class StepsTracker {
  constructor(storagePath = null) {
    this.storage = new Storage(storagePath);
    this.data = this.storage.load() || this.createEmptyProject();
  }

  /**
   * Create an empty project structure
   */
  createEmptyProject(name = 'Untitled Project') {
    return {
      project: name,
      steps: [],
      createdAt: new Date().toISOString(),
      lastModified: new Date().toISOString()
    };
  }

  /**
   * Initialize a new project
   */
  init(projectName = 'Untitled Project') {
    this.data = this.createEmptyProject(projectName);
    this.save();
    return this.data;
  }

  /**
   * Add a new step
   */
  addStep(description) {
    if (!description || description.trim() === '') {
      throw new Error('Step description cannot be empty');
    }

    const newStep = {
      id: this.getNextId(),
      description: description.trim(),
      completed: false,
      createdAt: new Date().toISOString(),
      completedAt: null
    };

    this.data.steps.push(newStep);
    this.data.lastModified = new Date().toISOString();
    this.save();
    return newStep;
  }

  /**
   * Get the next available step ID
   */
  getNextId() {
    if (this.data.steps.length === 0) {
      return 1;
    }
    const maxId = Math.max(...this.data.steps.map(s => s.id));
    return maxId + 1;
  }

  /**
   * List all steps
   */
  listSteps(filter = 'all') {
    switch (filter) {
      case 'completed':
        return this.data.steps.filter(s => s.completed);
      case 'pending':
        return this.data.steps.filter(s => !s.completed);
      default:
        return this.data.steps;
    }
  }

  /**
   * Get a step by ID
   */
  getStep(id) {
    return this.data.steps.find(s => s.id === id);
  }

  /**
   * Mark a step as complete
   */
  completeStep(id) {
    const step = this.getStep(id);
    if (!step) {
      throw new Error(`Step with ID ${id} not found`);
    }

    if (step.completed) {
      throw new Error(`Step ${id} is already completed`);
    }

    step.completed = true;
    step.completedAt = new Date().toISOString();
    this.data.lastModified = new Date().toISOString();
    this.save();
    return step;
  }

  /**
   * Mark a step as incomplete
   */
  uncompleteStep(id) {
    const step = this.getStep(id);
    if (!step) {
      throw new Error(`Step with ID ${id} not found`);
    }

    step.completed = false;
    step.completedAt = null;
    this.data.lastModified = new Date().toISOString();
    this.save();
    return step;
  }

  /**
   * Remove a step
   */
  removeStep(id) {
    const index = this.data.steps.findIndex(s => s.id === id);
    if (index === -1) {
      throw new Error(`Step with ID ${id} not found`);
    }

    const removed = this.data.steps.splice(index, 1)[0];
    this.data.lastModified = new Date().toISOString();
    this.save();
    return removed;
  }

  /**
   * Clear all completed steps
   */
  clearCompleted() {
    const beforeCount = this.data.steps.length;
    this.data.steps = this.data.steps.filter(s => !s.completed);
    const removed = beforeCount - this.data.steps.length;
    
    if (removed > 0) {
      this.data.lastModified = new Date().toISOString();
      this.save();
    }
    
    return removed;
  }

  /**
   * Get project status/statistics
   */
  getStatus() {
    const total = this.data.steps.length;
    const completed = this.data.steps.filter(s => s.completed).length;
    const pending = total - completed;
    const percentage = total > 0 ? Math.round((completed / total) * 100) : 0;

    return {
      project: this.data.project,
      total,
      completed,
      pending,
      percentage,
      createdAt: this.data.createdAt,
      lastModified: this.data.lastModified
    };
  }

  /**
   * Save current state to storage
   */
  save() {
    return this.storage.save(this.data);
  }

  /**
   * Check if project is initialized
   */
  isInitialized() {
    return this.storage.exists();
  }
}

module.exports = StepsTracker;
