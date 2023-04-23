# Critical Path Method application
### Java-based window application that creates ciritical path for the user-provided nodes. 

Project consists of 3 paths: 
- Method selection (2nd method: to be implemented)
- Adding nodes (user provides node's name, cost/time, next node)
- Graph creation

## Adding nodes

When user is adding nodes, it is important to remember:
- first node (first created) cannot has its cost/time set to 0,
- last node should have its cost/time set to 0,
- last node should not have any "Next Actions"

### Key-stroke combinations
- `Enter` adds node to the list,
- `Shift+Enter` generates the graph (based on the user-provided nodes)
- `Shift+Backspace` clears data from the table
