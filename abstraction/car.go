package main

import "fmt"

// Let's look at abstraction.
// Abstraction is a concept that allows for hiding the complexity and exposing only what's necessary.
// A real-life example is a car.

// A driver does not need to know about the inner mechanisms of a car in order to be able to drive it.
// Stuff like how the engine works, how fuel combustion provides thrust, or how gears work is abstracted away from the driver.

// The car's interface (pedals, steering wheel, keys) is what you, the driver, interacts with.

// We have a Car interface which contains three methods that we expect every instance of a car to possess: Start, Drive, and Stop.
type Car interface {
	Start()
	Drive()
	Stop()
}

type Sedan struct {
	make  string
	model string
}

func (s Sedan) Start() {
	fmt.Println("Sedan is starting")
}

func (s Sedan) Drive() {
	fmt.Println("Sedan is driving")
}

func (s Sedan) Stop() {
	fmt.Println("Sedan is stopping")
}

type SUV struct {
	make  string
	model string
}

func (s SUV) Start() {
	fmt.Println("SUV is starting")
}

func (s SUV) Drive() {
	fmt.Println("SUV is driving")
}

func (s SUV) Stop() {
	fmt.Println("SUV is stopping")
}

func main() {
	var car1 Car = Sedan{make: "Honda", model: "Accord"}
	car1.Start()
	car1.Drive()
	car1.Stop()

	var car2 Car = SUV{make: "Ford", model: "Explorer"}
	car2.Start()
	car2.Drive()
	car2.Stop()
}
