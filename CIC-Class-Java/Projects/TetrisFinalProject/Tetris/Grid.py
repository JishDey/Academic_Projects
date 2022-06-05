# Import and initialize the pygame library

import pygame
pygame.init()

# Set up the drawing window
screen = pygame.display.set_mode([500, 750])
screen.fill((255, 255, 255))

def fillSquareInGrid(x:int, y:int, c: pygame.Color):
    pygame.draw.rect(screen, c,(102 +(30*x), 102 +(30*y), 26, 26), 0)

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
while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
    # Fill the background with white
    screen.fill((255, 255, 255))
    drawGrid()

    # Flip the display
    pygame.display.flip()
    

# Done! Time to quit.
pygame.quit()



