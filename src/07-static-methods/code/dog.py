class Dog:
    def bark(self):
        print("Bark!")
    
    def eat(self):
        print("Eat!")

    def act_like_a_dog(self):
        self.bark()
        self.eat()

def main():
    dog = Dog()
    dog.act_like_a_dog()

main()