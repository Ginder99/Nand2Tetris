# Steps Tracker - Extraction Guide

This document explains how to extract the Steps Tracker project into its own standalone repository.

## What is Steps Tracker?

A lightweight, zero-dependency CLI application for tracking steps, tasks, and goals. Built with pure Node.js.

## Current Location

The Steps Tracker project is currently located in:
```
/steps-tracker/
```

within the Nand2Tetris repository.

## How to Extract to a New Repository

### Option 1: Manual Copy (Recommended for Clean Start)

1. **Create a new repository on GitHub**
   ```bash
   # On GitHub, create a new repository named "steps-tracker"
   ```

2. **Clone the new repository**
   ```bash
   git clone https://github.com/YOUR_USERNAME/steps-tracker.git
   cd steps-tracker
   ```

3. **Copy files from this location**
   ```bash
   # Copy all files from the steps-tracker directory
   cp -r /path/to/Nand2Tetris/steps-tracker/* .
   ```

4. **Initialize and commit**
   ```bash
   git add .
   git commit -m "Initial commit: Steps Tracker v1.0.0"
   git push origin main
   ```

### Option 2: Git Subtree (Preserves History)

1. **Create a new repository on GitHub**

2. **Extract with git subtree**
   ```bash
   cd /path/to/Nand2Tetris
   git subtree split --prefix=steps-tracker -b steps-tracker-branch
   ```

3. **Push to new repository**
   ```bash
   git push https://github.com/YOUR_USERNAME/steps-tracker.git steps-tracker-branch:main
   ```

## Files to Extract

All files in the `steps-tracker/` directory:

```
steps-tracker/
├── .gitignore           # Git ignore rules
├── LICENSE              # MIT License
├── README.md            # Main documentation
├── QUICKSTART.md        # Quick start guide
├── package.json         # Node.js project configuration
├── src/
│   ├── cli.js          # CLI interface (270 lines)
│   ├── storage.js      # Data persistence (77 lines)
│   └── tracker.js      # Core logic (189 lines)
├── data/
│   └── steps.example.json  # Example data file
└── examples/
    └── sample-project.md   # Usage examples
```

**Note**: The `data/steps.json` file (if exists) should NOT be copied as it contains user-specific data.

## Post-Extraction Checklist

After extracting to a new repository:

- [ ] Verify all files are present
- [ ] Update any repository-specific URLs in README.md
- [ ] Test the application works: `node src/cli.js help`
- [ ] Create a release tag: `git tag -a v1.0.0 -m "Initial release"`
- [ ] Update GitHub repository description
- [ ] Add topics/tags: `cli`, `tracker`, `nodejs`, `productivity`
- [ ] Consider adding:
  - [ ] GitHub Actions for CI/CD
  - [ ] Contributing guidelines (CONTRIBUTING.md)
  - [ ] Issue templates
  - [ ] Pull request templates

## Testing After Extraction

```bash
# Navigate to the new repository
cd steps-tracker

# Run help
node src/cli.js help

# Initialize a test project
node src/cli.js init "Test Project"

# Add a step
node src/cli.js add "Verify extraction works"

# List steps
node src/cli.js list

# Complete step
node src/cli.js complete 1

# Check status
node src/cli.js status
```

## Repository Settings Recommendations

### Description
```
A simple CLI application for tracking steps, tasks, and goals. Zero dependencies, pure Node.js.
```

### Topics
- cli
- tracker
- task-management
- productivity
- nodejs
- javascript
- todo
- goals

### About
- Website: Link to documentation or demo
- License: MIT
- No packages published yet

## Future Enhancements

Consider adding to the new repository:

1. **npm package**: Publish to npm registry
2. **GitHub Actions**: Automated testing
3. **More examples**: Video demos, screenshots
4. **Additional features**: Due dates, priorities, tags
5. **Tests**: Unit tests with a testing framework
6. **Web UI**: Optional web interface

## Support

Once extracted, set up:
- Issue templates for bugs and features
- Discussions for Q&A
- Wiki for extended documentation

---

**Ready to go!** The Steps Tracker is a complete, standalone project. 🚀
