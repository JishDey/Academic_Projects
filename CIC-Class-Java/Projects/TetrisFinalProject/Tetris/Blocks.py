# Import and initialize the pygame library
import random
import pygame


pygame.init()

# Set up the drawing window
screen = pygame.display.set_mode([500, 750])
screen.fill((255, 255, 255)) 
clock = pygame.time.Clock()

def fillSquareInGrid(x:int, y:int, c: pygame.Color):
    pygame.draw.rect(screen, c,(102 +(30*x), 102 +(30*y), 26, 26), 0)

#TODO: test this
def fillShape(x:int, y:int, r:int, shape: list[list]) -> bool: # refit for figures
    if x < -1 or x > 8: return False
    n = 0
    i = 0
    while n < 16:
        if(n == shape[r%4][i]):
            fillSquareInGrid(n%4 + x, n//4 + y, pygame.Color(45, 168, 190))
            if i < 3: i += 1
        n+=1
    return True

shapes = [
    [[1, 5, 9, 13], [4, 5, 6, 7], [1, 5, 9, 13], [4, 5, 6, 7]],
    [[4, 5, 9, 10], [2, 5, 6, 9], [4, 5, 9, 10], [2, 5, 6, 9]],
    [[6, 7, 9, 10], [1, 5, 6, 10], [6, 7, 9, 10], [1, 5, 6, 10]],
    [[1, 2, 5, 9], [0, 4, 5, 6], [1, 5, 8, 9], [4, 5, 6, 10]],
    [[1, 2, 6, 10], [5, 6, 7, 9], [2, 6, 10, 11], [3, 5, 6, 7]],
    [[1, 4, 5, 6], [1, 4, 5, 9], [4, 5, 6, 9], [1, 5, 6, 9]],
    [[9, 10, 13, 14], [9, 10, 13, 14], [9, 10, 13, 14], [9, 10, 13, 14]],
]


def drawGrid():
    n = 100
    while n <= 400:
        pygame.draw.line(screen, (0, 0, 0), (n,100), (n,700), 5)
        pygame.draw.line(screen, (0, 0, 0), (100, 2*n - 100), (400, 2*n - 100), 5)
        if n != 400:
            pygame.draw.line(screen, (0, 0, 0), (100, 2*n - 70), (400, 2*n - 70), 5)
        n += 30

# Run until the user asks to quit
running = True
r=0
q=0
x=4
y=4
while running:
    
    # Fill the background with white
    screen.fill((255, 255, 255))
    drawGrid()

    fillShape(x, y, r, shapes[q%7])
    for event in pygame.event.get():
        print(y)
        if event.type == pygame.QUIT:
            running = False
        if event.type == pygame.KEYDOWN:
            if event.key == pygame.K_UP:
                y-=1 
            if event.key == pygame.K_DOWN and y != 16:
                y+=1
            if event.key == pygame.K_LEFT and x > -1:
                x-=1
            if event.key == pygame.K_RIGHT and x < 8:
                x+=1
            if event.key == pygame.K_r:
                r+=1
            if event.key == pygame.K_t:
                q+=1
            


    # Flip the display
    pygame.display.flip()
    clock.tick(10)
    

# Done! Time to quit.
pygame.quit()



