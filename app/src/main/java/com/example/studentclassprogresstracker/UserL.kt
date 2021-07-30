package com.example.studentclassprogresstracker


/*data class UserL(var present : String? =null, var id : String? = null){
    constructor() : this()
}*/



class UserL {
    var present: String? = null
    var id: String? = null


    constructor() { }
    constructor(present: String?, id: String?) {
        this.present = present
        this.id = id

    }
}

