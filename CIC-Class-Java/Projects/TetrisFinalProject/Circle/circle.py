# Simple pygame program
#Source: https://realpython.com/pygame-a-primer/
# Import and initialize the pygame library
import pygame
pygame.init()

# Set up the drawing window
screen = pygame.display.set_mode([500, 500])

# Run until the user asks to quit
running = True
while running:

    # Did the user click the window close button?
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False

    # Fill the background with white
    screen.fill((130, 240, 255))

    # Draw a solid blue rectangle in the center
    pygame.draw.rect(screen, (0, 0, 255), (230, 250, 200, 200), 0)

    # Flip the display
    pygame.display.flip()

# Done! Time to quit.
pygame.quit()