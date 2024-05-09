fun main() {
//        var phonebook = Phonebook()
//
//        while (true) {
//            println("1. Add Contact")
//            println("2. Modify Contact")
//            println("3. Retrieve Contact")
//            println("4. Delete Contact")
//            println("5. Exit")
//
//            print("Enter your choice: ")
//            var choice = readLine()?.toIntOrNull()
//
//            when (choice) {
//                1 -> {
//                    println("Enter name: ")
//                    val name = readLine()!!
//                    println("Enter phone number: ")
//                    val phoneNumber = readLine()!!
//                    phonebook.addContact(name, phoneNumber)
//                    println("Contact added.")
//                }
//                2 -> {
//                    println("Enter name: ")
//                    val name = readLine()!!
//                    println("Enter new phone number: ")
//                    val newPhoneNumber = readLine()!!
//                    phonebook.modifyContact(name, newPhoneNumber)
//                    println("Contact modified.")
//                }
//                3 -> {
//                    println("Enter name: ")
//                    val name = readLine()!!
//                    val contact = phonebook.retrieveContact(name)
//                    if (contact!= null) {
//                        println("Name: ${contact.name}, Phone Number: ${contact.phoneNumber}")
//                    } else {
//                        println("Contact not found.")
//                    }
//                }
//                4 -> {
//                    println("Enter name: ")
//                    val name = readLine()!!
//                    phonebook.deleteContact(name)
//                    println("Contact deleted.")
//                }
//                5 -> {
//                    println("Exiting...")
//                    break
//                }
//                else -> println("Invalid choice. Please try again.")
//            }
//        }
    var tracker = Tracker()
    tracker.addWorkout(1, "Running", 23)
    tracker.addWorkout(2, "Cycling", 24)
    tracker.addWorkout(3, "Running", 25)
    tracker.addWorkout(4, "Cycling", 25)
    tracker.removeWorkout(2)
    tracker.searchWorkout(1)
    tracker.listWorkout()
    println(tracker.searchWorkout(1))
    tracker.totalCalories()
    tracker.getAllworkoutsrun()
}


data class workout(var id: Int, var type: String, var calorieBurned: Int)

class Tracker (){
    val workouts = mutableListOf<workout>()
    fun addWorkout(id: Int, type: String, calorieBurned: Int) {
        val work = workout(id, type, calorieBurned)
        workouts.add(work)
        println("Workout added successfully")
    }
    fun removeWorkout(id: Int){
        val index = workouts.indexOfFirst { it.id == id }
        if (index != -1){
            workouts.removeAt(index)
            println("Workout $id  is removed successfully")
        }
        else{
            println("Workout with ID $id is not found.")
        }
    }
    fun searchWorkout(id:Int):workout?{
        return workouts.find { it.id ==id }
    }
    fun listWorkout(){
        if (workouts.isNotEmpty()){
            println(workouts)
        }
        else{
            println("No workout tracked yet")
        }
    }
    fun totalCalories(){
        var x = workouts.sumBy { it.calorieBurned }
        println(x)
    }
    fun getAllworkoutsrun(){
        println(workouts.filter { workout -> workout.type == "Running"  })
    }
}









data class Contact(var name: String, var phoneNumber: String)

class Phonebook {
    private val contacts = mutableMapOf<String, Contact>()

    fun addContact(name: String, phoneNumber: String) {
        contacts[name] = Contact(name, phoneNumber)
    }

    fun modifyContact(name: String, newPhoneNumber: String) {
        contacts[name]?.phoneNumber = newPhoneNumber
    }

    fun retrieveContact(name: String): Contact? {
        return contacts[name]
    }

    fun deleteContact(name: String) {
        contacts.remove(name)
    }
}

data class Workout(
    val id: Int,
    val type: String,
    val caloriesBurned: Int,
    val durationMinutes: Int
)

class WorkoutSystem {
    private val workouts = mutableListOf<Workout>()
    private var nextId = 0 // or 1 or use post increment
    fun addWorkout(type: String, caloriesBurned: Int, durationMinutes: Int) {
        val workout = Workout(++nextId, type, caloriesBurned, durationMinutes)
        workouts.add(workout)
        println("Workout added successfully.")
    }

    fun searchWorkoutByType(type: String): Workout? {
        return workouts.find { it.type.lowercase() == type.lowercase() }
        //you can use .filter in this
    }

    fun showAllWorkouts() {
        if (workouts.isEmpty()) {
            println("No workouts in the system.")
        } else {
//            workouts.forEach {
//                println("ID: ${it.id}, Type: ${it.type}, Calories Burned: ${it.caloriesBurned}, Duration: ${it.durationMinutes} minutes")
//            }
            println(workouts)
        }
    }

    fun removeWorkout(id: Int) {
        val workout = workouts.find { it.id == id }
        println(workout)
        if (workout != null) {
            workouts.remove(workout)
            println("Workout with ID $id removed successfully.")
        } else {
            println("Workout with ID $id not found.")
        }
    }

    fun calculateTotalCaloriesBurned(): Int {
//        return workouts.sumOf { it.caloriesBurned }
        var sum = 0
        for (i in workouts){
            sum+=i.caloriesBurned
        }
        return sum
    }
}