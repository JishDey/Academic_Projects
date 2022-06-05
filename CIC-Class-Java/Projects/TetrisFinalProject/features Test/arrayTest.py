import pygame

pygame.init()


# myList: list[list[int]] = list([[3, 5, 7],[5, 4, 7, 2, 9]])
# myList[1][2] = 482
# print(myList)


grid: list[list[pygame.Color]] = [[0] *10 for i in range(20)]
print(grid)
lastrow = [1] *10
print(lastrow)
grid.append(lastrow)
for row in grid: 
  print(row)


