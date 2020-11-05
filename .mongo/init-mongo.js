db.createUser(
    {
        user: "root",
        pwd: "CwWhBh2evZAV5tnmczzwMJqDbtmeEuxz",
        roles: [ { role: "userAdminAnyDatabase", db: "admin" }, "readWriteAnyDatabase" ]
    }
);