// In order for a class to be considered drivable, we expect it to possess/implement these three methods.
// So we add them to the interface.

interface Drivable {
	fun start()
	fun drive()
	fun stop()
}

// We expect our cars to be drivable, meaning that no matter what the car is, they should implement the methods of Drivable interface.

abstract class Car(val make: String, val model: String) : Drivable {
	override fun start() {
		println("$make $model is starting...")
	}
	
	override fun drive() {
		println("$make $model is driving...")
	}

	override fun stop() {
		println("$make $model is stopping...")
	}
}

// Finally, we'll have our classes: Sedan and SUV.
// If we want a certain method to print something different to the standard output other than what's already implemented in the abstract class, we can override them here.
// If no methods are overridden, the default behaviour will be inherited from the abstract class.
class Sedan(make: String, model: String) : Car(make, model) {
	override fun drive() {
		println("$make $model sedan is driving")
	}
}

class SUV(make: String, model: String) : Car(make, model) {
	override fun start() {
		println("$make $model SUV is getting ready to hit the road")
	}
}

fun main() {
	val sedan: Drivable = Sedan("Honda", "Accord")
	sedan.start()
	sedan.drive()
	sedan.stop()

	val suv: Drivable = SUV("Ford", "Explorer")
	suv.start()
	suv.drive()
	suv.stop()
}