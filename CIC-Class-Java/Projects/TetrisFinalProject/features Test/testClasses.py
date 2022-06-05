


class Tes:
    classVar = 1

    def __init__(self):
        self.objVar = "e"
    def change_ObjVar(self, x, y):
        self.objVar += x + y


v = Tes()


print(Tes.classVar)
print(v.classVar)
print(v.objVar)

print(v.objVar)