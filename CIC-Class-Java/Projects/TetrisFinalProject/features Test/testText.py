
import pygame

pygame.init()


screen = pygame.display.set_mode([500, 500])
clock = pygame.time.Clock()

running = True
n=0
X = 400
Y = 400
white = (255, 255, 255)
green = (0, 255, 0)
blue = (0, 0, 128)


font = pygame.font.Font('freesansbold.ttf', 20)
text = font.render('Score: ' + str(n), True, pygame.Color(255, 255, 255), pygame.Color(0, 0, 0))
textRect = text.get_rect()
textRect.center = (50, 50)

def draw_text(text:str):
    text = font.render(text, True, pygame.Color(255, 255, 255), pygame.Color(0, 0, 0))
    screen.blit(text, textRect) 



while running:

    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False


    screen.fill((255, 255, 255))
    draw_text('Score: ' + str(n))

    pygame.display.flip()
    if n < 255:
        n+= 1
    else:
        n = 0
    
    clock.tick(30)


pygame.quit()