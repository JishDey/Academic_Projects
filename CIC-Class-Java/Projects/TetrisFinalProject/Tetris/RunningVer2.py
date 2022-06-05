
import pygame
import random

pygame.init()
screen = pygame.display.set_mode([500, 750])
clock = pygame.time.Clock()

Blue = pygame.Color(0, 0, 255)
Orange = pygame.Color(255, 100, 0)

font = pygame.font.Font('freesansbold.ttf', 20)
text = font.render('Score: ', True, pygame.Color(255, 255, 255), pygame.Color(0, 0, 0))
textRect = text.get_rect()
textRect.center = (50, 50)

def draw_text(text:str):
    text = font.render(text, True, pygame.Color(255, 255, 255), pygame.Color(0, 0, 0))
    screen.blit(text, textRect)

def fillSquareInGrid(y:int, x:int, c: pygame.Color):
    pygame.draw.rect(screen, c,(102 +(30*x), 102 +(30*y), 26, 26), 0)

def fillGridSquares(LIIst: list[list[pygame.Color]]):
    i = 0
    while i < 20:
        j = 0
        while j < len(LIIst[i]):
            color = LIIst[i][j]
            # print(color)
            if color != None:
                fillSquareInGrid(i, j, LIIst[i][j])
            j += 1
        i += 1

def drawGrid():
    n = 100
    while n <= 400:
        pygame.draw.line(screen, (255, 255, 255), (n,100), (n,700), 2)
        pygame.draw.line(screen, (225, 225, 225), (100, 2*n - 100), (400, 2*n - 100), 2)
        if n != 400:
            pygame.draw.line(screen, (250, 250, 250), (100, 2*n - 70), (400, 2*n - 70), 2)
        n += 30

boundShape = [
    [[0, 3, 12, 15], [0, 3, 12, 15], [0, 3, 12, 15], [0, 3, 12, 15]],
    [[0, 3, 12, 15], [0, 3, 12, 15], [0, 3, 12, 15], [0, 3, 12, 15]],
    [[0, 3, 12, 15], [0, 3, 12, 15], [0, 3, 12, 15], [0, 3, 12, 15]],
    [[0, 3, 12, 15], [0, 3, 12, 15], [0, 3, 12, 15], [0, 3, 12, 15]],
    [[0, 3, 12, 15], [0, 3, 12, 15], [0, 3, 12, 15], [0, 3, 12, 15]],
    [[0, 3, 12, 15], [0, 3, 12, 15], [0, 3, 12, 15], [0, 3, 12, 15]],
    [[0, 3, 12, 15], [0, 3, 12, 15], [0, 3, 12, 15], [0, 3, 12, 15]],
] 

class Tetronimo: #rename to tetris?

    storeBoard: list[list[pygame.Color]] = [[None] *10 for i in range(20)] #color?
    storeBoard.append([pygame.Color(0, 0, 0)] *10)

    shapes = [
    [[1, 5, 9, 13], [4, 5, 6, 7], [1, 5, 9, 13], [4, 5, 6, 7]],
    [[4, 5, 9, 10], [2, 5, 6, 9], [4, 5, 9, 10], [2, 5, 6, 9]],
    [[6, 7, 9, 10], [1, 5, 6, 10], [6, 7, 9, 10], [1, 5, 6, 10]],
    [[1, 2, 5, 9], [0, 4, 5, 6], [1, 5, 8, 9], [4, 5, 6, 10]],
    [[1, 2, 6, 10], [5, 6, 7, 9], [2, 6, 10, 11], [3, 5, 6, 7]],
    [[1, 4, 5, 6], [1, 4, 5, 9], [4, 5, 6, 9], [1, 5, 6, 9]],
    [[1, 2, 5, 6], [1, 2, 5, 6], [1, 2, 5, 6], [1, 2, 5, 6]],
    ]
    
    colorList = [pygame.Color(130, 240, 255), pygame.Color(255, 82, 82), pygame.Color(111, 252, 101), pygame.Color(55, 41, 179), pygame.Color(230, 141, 25), pygame.Color(184, 15, 141), pygame.Color(250, 221, 0)]
    
    def __init__(self, piece:int):
        self.piece = piece
        self.tshape = Tetronimo.shapes[piece]
        self.cx = 3
        self.cy = 0
        self.r = 0

    def row_filled(y:int) -> bool: #rowfilled
        i = 0
        while i < 10:
            if Tetronimo.storeBoard[y][i] == None:
                return False
            i += 1
        return True

    def flip_row(y:int): #fliprow
        Tetronimo.storeBoard.pop(y)
        Tetronimo.storeBoard.insert(0, [None] *10)

    def get_gridsquares(self) -> list[int, int]:
        fin = list()
        for n in self.tshape[self.r]:
            a = list()
            a.append(int(n/4) + self.cy)
            a.append(n%4 + self.cx)
            fin.append(list(a))   
        return fin
    
    def get_rt_gridsquares(self) -> list[int, int]:
        fin = list()
        for n in self.tshape[(self.r+1)%4]:
            a = list()
            a.append(int(n/4) + self.cy)
            a.append(n%4 + self.cx)
            fin.append(list(a)) 
        return fin

    def can_rotate(self) -> bool:
        rtlst = self.get_rt_gridsquares()
        for coords in rtlst:
           if(coords[1] < 0 or coords[1] > 9 or Tetronimo.storeBoard[coords[0]][coords[1]] != None):
               return False
        return True

    def rotate(self):
        self.r+=1
        if self.r == 4:
            self.r = 0

    def draw(self, coordList):
        for crnt in coordList:
            fillSquareInGrid(crnt[0], crnt[1], Tetronimo.colorList[self.piece])

    def can_move_left(self, coordList) -> bool:
        for coords in coordList:
           if(coords[1] == 0 or Tetronimo.storeBoard[coords[0]][coords[1] -1] != None): 
               return False
        return True

    def move_left(self):
        self.cx -= 1

    def can_move_right(self, coordList) -> bool:
        for coords in coordList:
            if(coords[1] == 9 or Tetronimo.storeBoard[coords[0]][coords[1] +1] != None):
               return False
        return True

    def move_right(self):
        self.cx += 1

    def can_move_down(self, coordList) -> bool:
       for coords in coordList:
           if(Tetronimo.storeBoard[coords[0] +1][coords[1]] != None):
               return False
       return True
           
    
    def move_down(self):
        self.cy += 1


#game loop
randominteger = random.randint(0,6)
currentPiece = Tetronimo(randominteger)
screen.fill((255, 255, 255))
running = True
framebyn = 0
score = 0

while running:
    coordList = currentPiece.get_gridsquares()

    if framebyn == 5: #also if it can move down
        framebyn = 0
        if currentPiece.can_move_down(coordList):
            currentPiece.move_down()
        else:
            for coord in coordList:
                Tetronimo.storeBoard[coord[0]][coord[1]] = Tetronimo.colorList[currentPiece.piece]
            currentPiece = Tetronimo(random.randint(0, 6))
            coordList = currentPiece.get_gridsquares()
            if not currentPiece.can_move_down(coordList):
                print("game over. \n your score was " + str(score) + ".")
                running = False
        score += 1

    else:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                running = False
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_r:
                    currentPiece = Tetronimo(random.randint(0, 6))
                if event.key == pygame.K_DOWN and currentPiece.can_move_down(coordList):
                    currentPiece.move_down()
                    score += 1
                if event.key == pygame.K_LEFT and currentPiece.can_move_left(coordList):
                    currentPiece.move_left()
                if event.key == pygame.K_RIGHT and currentPiece.can_move_right(coordList):
                    currentPiece.move_right()
                if event.key == pygame.K_UP and currentPiece.can_rotate():
                    currentPiece.rotate()
                if event.key == pygame.K_SPACE:
                    while currentPiece.can_move_down(coordList):
                        currentPiece.move_down()
                        coordList = currentPiece.get_gridsquares()
                        score += 1

    screen.fill((0, 0, 0))
    drawGrid()
    fillGridSquares(Tetronimo.storeBoard)
    draw_text("Score: " + str(score))
    currentPiece.draw(coordList)

    scorei = 19
    while(scorei>0):
        if Tetronimo.row_filled(scorei):
            Tetronimo.flip_row(scorei)
            score += 100
        scorei -= 1

    framebyn += 1
    pygame.display.flip()
    clock.tick(15)

screen.fill((255, 255, 255))
font = pygame.font.Font('freesansbold.ttf', 30)
text = font.render('Score: ', True, pygame.Color(0, 0, 0), pygame.Color(255, 255, 255))
textRect = text.get_rect()
textRect.center = (80, 375)
draw_text("Game over. You had " + str(score) + " points.")
pygame.display.flip()
pygame.time.delay(1500)