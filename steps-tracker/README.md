# Steps Tracker

A simple, lightweight CLI application for tracking your steps, tasks, and goals. Perfect for managing multi-step projects, learning paths, or daily task lists.

## Features

- ✅ Create and manage steps/tasks
- 📝 Track progress on individual steps
- 🎯 Mark steps as complete
- 📊 View progress statistics
- 💾 Persistent storage (JSON-based)
- 🚀 Simple CLI interface

## Installation

### Prerequisites
- Node.js 14.x or higher
- npm 6.x or higher

### Setup

```bash
# Clone the repository
git clone <repository-url>
cd steps-tracker

# Install dependencies
npm install

# Make the CLI executable (optional)
npm link
```

## Usage

### Basic Commands

```bash
# Initialize a new steps tracker project
node src/cli.js init

# Add a new step
node src/cli.js add "Complete project setup"

# List all steps
node src/cli.js list

# Mark a step as complete
node src/cli.js complete 1

# Show progress summary
node src/cli.js status

# Remove a step
node src/cli.js remove 1

# Clear all completed steps
node src/cli.js clear
```

### Examples

```bash
# Track a learning path
node src/cli.js init "Learn JavaScript"
node src/cli.js add "Study variables and data types"
node src/cli.js add "Learn functions and scope"
node src/cli.js add "Master async/await"
node src/cli.js list

# Mark steps as you complete them
node src/cli.js complete 1
node src/cli.js status
```

## Project Structure

```
steps-tracker/
├── README.md           # This file
├── package.json        # Node.js dependencies
├── .gitignore         # Git ignore rules
├── src/
│   ├── cli.js         # CLI interface
│   ├── tracker.js     # Core tracker logic
│   └── storage.js     # Data persistence
├── data/
│   └── steps.json     # Steps data (auto-generated)
└── examples/
    └── sample-project.md  # Example usage
```

## Data Format

Steps are stored in JSON format:

```json
{
  "project": "My Project",
  "steps": [
    {
      "id": 1,
      "description": "Step description",
      "completed": false,
      "createdAt": "2026-02-06T07:00:00.000Z",
      "completedAt": null
    }
  ],
  "createdAt": "2026-02-06T07:00:00.000Z"
}
```

## API

### StepsTracker Class

```javascript
const StepsTracker = require('./src/tracker');

const tracker = new StepsTracker();

// Initialize a project
tracker.init('My Project');

// Add steps
tracker.addStep('First step');
tracker.addStep('Second step');

// List steps
const steps = tracker.listSteps();

// Complete a step
tracker.completeStep(1);

// Get status
const status = tracker.getStatus();
```

## Development

### Running Tests

```bash
npm test
```

### Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

MIT License - feel free to use this project for any purpose.

## Future Enhancements

- [ ] Add due dates for steps
- [ ] Support for sub-steps/nested tasks
- [ ] Priority levels
- [ ] Tags and categories
- [ ] Export to different formats (CSV, Markdown)
- [ ] Team collaboration features
- [ ] Web interface
- [ ] Mobile app

## Support

For issues, questions, or suggestions, please open an issue on GitHub.

---

**Happy tracking! 🎯**
