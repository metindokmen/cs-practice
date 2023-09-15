// Polymorphism is a concept where a single interface represents different types of objects.

// Think of electronic devices such as a TV, a radio, and a computer.
// They can all be turned on and off, but they function differently and are used for different purposes.
// For the end-user, though, the action of pressing a power button is consistent across devices.
// So turning a device on or off is a polymorphic behavior.

// In this example, each class will represent a different device, but they will all implement the same interface.

interface ElectronicDevice {
	fun turnOn()
	fun turnOff()
}

class TV : ElectronicDevice {
	override fun turnOn() {
		println("TV is on")
	}

	override fun turnOff() {
		println("TV is off")
	}
}

class Radio : ElectronicDevice {
	override fun turnOn() {
		println("Radio is on")
	}

	override fun turnOff() {
		println("Radio is off")
	}
}

class Computer : ElectronicDevice {
	override fun turnOn() {
		println("Computer is on")
	}

	override fun turnOff() {
		println("Computer is off")
	}
}

fun main() {
	val tv: ElectronicDevice = TV()
	val radio: ElectronicDevice = Radio()
	val computer: ElectronicDevice = Computer()

	tv.turnOn()
	radio.turnOn()
	computer.turnOn()

	tv.turnOff()
	radio.turnOff()
	computer.turnOff()
}