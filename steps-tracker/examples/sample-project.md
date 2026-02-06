# Sample Project - Learning Path Example

This example demonstrates how to use Steps Tracker to manage a learning path.

## Step 1: Initialize the Project

```bash
node src/cli.js init "Learn Web Development"
```

Output:
```
✓ Initialized project: "Learn Web Development"
```

## Step 2: Add Steps

```bash
node src/cli.js add "Learn HTML basics"
node src/cli.js add "Learn CSS fundamentals"
node src/cli.js add "Learn JavaScript essentials"
node src/cli.js add "Build first website"
node src/cli.js add "Deploy to production"
```

## Step 3: View All Steps

```bash
node src/cli.js list
```

Output:
```
Learn Web Development
=====================
[ ] 1. Learn HTML basics
[ ] 2. Learn CSS fundamentals
[ ] 3. Learn JavaScript essentials
[ ] 4. Build first website
[ ] 5. Deploy to production
```

## Step 4: Complete Steps as You Go

```bash
node src/cli.js complete 1
node src/cli.js complete 2
```

Output:
```
✓ Completed step 1: "Learn HTML basics"
✓ Completed step 2: "Learn CSS fundamentals"
```

## Step 5: Check Progress

```bash
node src/cli.js status
```

Output:
```
Project: Learn Web Development
────────────────────────────────────────
Total steps:     5
Completed:       2
Pending:         3
Progress:        40%
────────────────────────────────────────
[████████████░░░░░░░░░░░░░░░░░░] 40%
```

## Step 6: View Pending Steps

```bash
node src/cli.js list pending
```

Output:
```
Learn Web Development
=====================
[ ] 3. Learn JavaScript essentials
[ ] 4. Build first website
[ ] 5. Deploy to production
```

## Step 7: Complete All and Clear

```bash
node src/cli.js complete 3
node src/cli.js complete 4
node src/cli.js complete 5
node src/cli.js clear
```

This removes all completed steps, leaving you with a clean slate for new tasks!

## Other Useful Commands

### Remove a Specific Step
```bash
node src/cli.js remove 3
```

### Mark a Step as Incomplete
```bash
node src/cli.js uncomplete 2
```

### View Only Completed Steps
```bash
node src/cli.js list completed
```

## Tips

1. **Be Specific**: Write clear, actionable step descriptions
2. **Break Down**: Large tasks into smaller, manageable steps
3. **Regular Updates**: Mark steps complete as you finish them
4. **Check Progress**: Use `status` command regularly for motivation
5. **Clean Up**: Use `clear` to remove old completed steps

---

Happy tracking! 🎯
