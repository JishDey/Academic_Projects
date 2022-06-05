import pygame
import random
pygame.init()
 
# TODO: fill out tetris colors
Red = pygame.Color(255, 0, 0)
Green = pygame.Color(0, 255, 0)
Blue = pygame.Color(0, 0, 255)
White = pygame.Color(255, 255, 255)
Black = pygame.Color(0, 0, 0, 225)


def fillSquareInGrid(x:int, y:int, c: pygame.Color):
    pygame.draw.rect(screen, c,(102 +(30*x), 102 +(30*y), 26, 26), 0)

#TODO: test this
def fillGridSquares(LIIst: list[list[pygame.Color]]):
   for i in LIIst:
        for j in LIIst[i]:
            fillSquareInGrid(i, j, LIIst[i][j])

         

screen = pygame.display.set_mode([500, 750])
screen.fill((255, 255, 255))
n = 100
clock = pygame.time.Clock()
grid: list[list[pygame.Color]] = [[None] *10 for i in range(21)]

#create grid
while n <= 400:
    pygame.draw.line(screen, (0, 0, 0), (n,100), (n,700), 5)
    pygame.draw.line(screen, (0, 0, 0), (100, 2*n - 100), (400, 2*n - 100), 5)
    if n != 400:
        pygame.draw.line(screen, (0, 0, 0), (100, 2*n - 70), (400, 2*n - 70), 5)
    n += 30

#game loop
running = True #TODO:replace with Game field state
y=0
x = 4
px = 3
ccolor = Red
while running: 
    ofst = 1
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_LEFT and x!=0 and grid[y][x-1] == None:
                x -=1
            if event.key == pygame.K_RIGHT and x!= 9 and grid[y][x+1] == None:
                x +=1
            if event.key ==pygame.K_DOWN and y < 19 and grid[y+1][x] == None:
                y +=1
                ofst +=1
    # Fill the background with white
    #screen.fill((255, 255, 255))

    # Flip the display
    fillSquareInGrid(x, y, ccolor)
    fillSquareInGrid(px, y - ofst, White)
    print("x: " + str(x))
    print("y: " + str(y))

    #new piece
    print(ofst)
    if grid[y+1][x] != None or y == 19: 
        grid[y][x] = ccolor
        #for line in grid:
            #print(line)
        print("newpiece")
        y = 0
        ccolor = pygame.Color(random.randint(0, 255),random.randint(0, 255),random.randint(0, 255)) #new piece
    
    pygame.display.flip()
    px = x
    y += 1
    clock.tick(2)

pygame.quit()