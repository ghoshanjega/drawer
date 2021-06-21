Paint console application

## Supported commands
```bash
C [width] [height]
L [x1] [y1] [x2] [y2]
R [x1] [y1] [x2] [y2]
B [x] [y] [color]
```
## Known caveats
- Points that are mentioned outside the canvas doesn't throw any error. It just doesnt show on the canvas
- Lines follow a basic euclidean distance based heuristics and therefore the diagonal lines drawn are not the most visually pleasing.
- Bucket fill algorithm is [bfs flood fill](https://www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/). This doesnt recognize diagonal points as neighbouring entity and would not fill it. (This behaviour is also seen in paint when zoomed to individual pixel level)