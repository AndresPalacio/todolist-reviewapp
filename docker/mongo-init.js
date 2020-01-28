db.createUser(
    {
        user: "jeapalac",
        pwd : "jeapalac123",
        roles : [
            {   
                role : "readWrite",
                db   : "test"
            }
        ]
    }

)