package main

// Let's look at abstraction.
// Abstraction is a concept that allows for hiding the complexity and exposing only what's necessary.
// A real-life example is a car.

// A driver does not need to know about the inner mechanisms of a car in order to be able to drive it.
// Stuff like how the engine works, how fuel combustion provides thrust, or how gears work is abstracted away from the driver.

// The car's interface (pedals, steering wheel, keys) is what you, the driver, interacts with.

type Car struct {
	make  string
	model string
}
