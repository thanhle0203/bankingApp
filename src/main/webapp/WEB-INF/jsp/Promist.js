// callbacks and callbacks and callbacks - becomes full of callback function
//signinuser

// function Authentication(userInfo) {} //Login SignUp, create userSession
// function Authorization(userInfo, sessionId) {} // Permissions to access like admin/normal user
// function Navigation(userInfo, permissions) {} // what all pages user can navigate, returns first page

// function SignInSignupUser(authCallback, authorizationCallBk, navigationCallBk) {
//     let session = Authentication(username, password) // get valid user session

//     if (session == IsValid) {
//         let permission = Authorization(user, session) //api crashed
        
//         let permissionPromiseObject = new Promise((resolve, reject)=>{
//             let permission = Authorization(user, session)
//             if (permission.status == success) {
//                 return resolve(permission) //this will be accessed in promise.then
//             } else {
//                 return reject("No Response") //this will be accessed in promise.catch
//             } 
//         })

//         permissionPromiseObject.then((object)=>{
//             //statement for successfull calls
//         }).catch((error)=>{
//             //statement for failed calls
//         })


//         if (permission == "Admin") {
//             let nextPage = Navigation(permission)
//         } else if(permission == "Guest"){
//             let nextPage = Navigation(permission)
//         } else {
//             //if not modularized well then it falls in loop of callbacks and 
//             //creates situation of callback hell
//             SignInSignupUser(Authentication, Authorization, Navigation) 
//         }

//     } else {
        
//     }

// }
// SignInSignupUser(Authentication, Authorization, Navigation)


//Promises : These are the proxy objects that give us a control to check the status of promise and 
// upon revelant status we also get the type, payload associated with that in response
// promise will have 3 states - pending, fullfilled/resolved (then), rejected (catch)

let LunchPromise = new Promise((resolve, reject)=>{

    //set timeout is assumed to be the server call / async call
    setTimeout(() => {
        resolve({ //this out put is assumed to be sent from server in async call on success case
            "Planned" : "Yes",
            "Status" : "Success",
            "Status Code" : 200
        })
    }, 3000);    

    setTimeout(() => {
        reject({ //this out put is assumed to be sent from server in async call on success case
            "Planned" : "Yes",
            "Status" : "Failed",
            "Status Code" : 500
        })
    }, 2000);    
})

console.log("Promise Status!!! ", LunchPromise);

LunchPromise.then((data)=>{
    console.log(data)
}).catch((err)=>{
    console.log(err)
})

console.log("Promise Completed!!!");



// create a promise object with name student on it after 2 seconds student is pass (resolved case)
// and set status stating learnt es6
// then for rejected case set that status - i am progressing
let nameStudent = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve({
            "firstName": "Thanh",
            "lastName": "Le",
            "status": "es6"
        },);
    }, 2000);

    setTimeout(() => {
        resolve({
            "firstName": "Thanh",
            "lastName": "Le",
            "status": "I am progressing"
        },);
    }, 2000);
})

nameStudent.then((data) => {
    console.log(data)
}).catch((error) => {
    console.log(error);
    
})