interface Drivable {
	fun start()
	fun drive()
	fun stop()
}

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