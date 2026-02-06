const fs = require('fs');
const path = require('path');

/**
 * Storage class for persisting steps data
 */
class Storage {
  constructor(dataPath = null) {
    this.dataPath = dataPath || path.join(__dirname, '../data/steps.json');
    this.ensureDataDirectory();
  }

  /**
   * Ensure the data directory exists
   */
  ensureDataDirectory() {
    const dir = path.dirname(this.dataPath);
    if (!fs.existsSync(dir)) {
      fs.mkdirSync(dir, { recursive: true });
    }
  }

  /**
   * Load data from storage
   */
  load() {
    try {
      if (fs.existsSync(this.dataPath)) {
        const data = fs.readFileSync(this.dataPath, 'utf8');
        return JSON.parse(data);
      }
      return null;
    } catch (error) {
      console.error('Error loading data:', error.message);
      return null;
    }
  }

  /**
   * Save data to storage
   */
  save(data) {
    try {
      const jsonData = JSON.stringify(data, null, 2);
      fs.writeFileSync(this.dataPath, jsonData, 'utf8');
      return true;
    } catch (error) {
      console.error('Error saving data:', error.message);
      return false;
    }
  }

  /**
   * Check if data file exists
   */
  exists() {
    return fs.existsSync(this.dataPath);
  }

  /**
   * Delete the data file
   */
  delete() {
    try {
      if (fs.existsSync(this.dataPath)) {
        fs.unlinkSync(this.dataPath);
        return true;
      }
      return false;
    } catch (error) {
      console.error('Error deleting data:', error.message);
      return false;
    }
  }
}

module.exports = Storage;
