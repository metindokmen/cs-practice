// Inheritence is a mechanism where a new class inherits properties and behaviors frmo an existing class.
// Think of how a child inherits certain traits from his/her parents

// In programming, the parent class or the base class is the previous generation.
// The child or the derived class is the new generation.
// The child inherits certain attributes from the parent but can also introduce its own or modify the inherited ones.

open class Vehicle(val brand: String) {
	fun displayBrand() {
		println("This vehicle is made by $brand")
	}

	open fun move() {
		println("The vehicle moves.")
	}
}

class Car(brand: String, val type: String) : Vehicle(brand) {
	// Derived/child class Car overrides the move method of its parent.
	override fun move() {
		println("The car drives on the road.")
	}

	// Derived/child class Car has a method unique to its own that is NOT inherited from its parent.
	fun displayType() {
		println("This car is a $type")
	}
}

class Boat(brand: String) : Vehicle(brand) {
	// Derived/child class Boat overrides the move method of its parent.
	override fun move() {
		println("The boat sails on water.")
	}

	// But it does not have any unique methods, nor does it have to.
}

fun main() {
	val car = Car("Ford", "SUV")
	car.displayBrand()
	car.displayType()
	car.move()

	val boat = Boat("Yamaha")
	boat.displayBrand()
	boat.move()
}