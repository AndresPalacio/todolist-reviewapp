var db = connect("mongodb://localhost/admin");
db.createUser({
    user: "jeapalac",
    pwd: "jeapalac123",
    roles: [ { role: "readWrite", db: "admin" } ]
  })
 