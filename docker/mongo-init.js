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

);
db.auth("jeapalac", "jeapalac123")
db.grantRolesToUser("jeapalac", [ { role: "readWrite", db: "test" } ])
