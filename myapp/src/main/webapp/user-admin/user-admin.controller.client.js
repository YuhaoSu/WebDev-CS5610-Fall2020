// alert("Hello from JavaScript")
(function () {

    let users = [
        {
            username: 'Alice',
            fname: 'Alice',
            lname: 'Wonderland',
            role: 'Faculty'
        },
        {
            username: 'bob',
            fname: 'Robert',
            lname: 'Marley',
        },
        {
            username: 'charlie',
            fname: 'Charlie',
            lname: 'Garcia',
        }
    ]

    let $tbody
    let $userRowTemplate
    let clone
    let $usernameFld, $passwordFld
    let $createBtn, $removeBtn, $editBtn
    let $firstNameFld, $lastNameFld, $roleFld
    const userService = new AdminUserServiceClient()

    // const deleteUser1 = (event) => {
    //     const deleteBtn = $(event.currentTarget)
    //     // deleteBtn.parent().parent().remove()
    //     // console.log("delete user 1")
    //     // console.log(deleteBtn)
    //     deleteBtn.parents("tr.wbdv-template").remove()
    // }

    let selectedtUserIndex = -1
    const selectUser = (index) => {
        selectedtUserIndex = index
        $("#usernameFld").val(users[index].username)
        $("#firstNameFld").val(users[index].first)
    }

    const renderUsers = (users) => {
        $tbody.empty()
        const ul = $("<ul>")
        for (let i = 0; i < users.length; i++) {
            const user = users[i]
            // console.log(user.username)
            const li = $("<li>" + user.username + "</li>")
            ul.append(li)

            clone = $userRowTemplate.clone()
            clone.removeClass("wbdv-hidden")

            clone.find(".wbdv-username").html(user.username)
            clone.find(".wbdv-first-name").html(user.first)
            clone.find(".wbdv-last-name").html(user.last)
            clone.find(".wbdv-remove").click(() => deleteUser(i))
            clone.find(".wbdv-edit").click(() => selectUser(i))

            $tbody.append(clone)
        }
        container.append(ul)
    }

    const deleteUser = (_index) => {
        // console.log(index)
        const user = users[_index]
        const userId = user._id
        userService.deleteUser(userId)
            .then(response => {
                users.splice(_index, 1)
                renderUsers(users)
            })
    }

// const heading1 = jQuery("h1") //grab element
// heading1.remove() //cannot work, because js loaded before h1
// solution 1 put loading js line after this
//solution 2 : use init

    const createUser = () => {
        console.log("create user")
        const username = $usernameFld.val()
        const firstName = $firstNameFld.val()

        $usernameFld.val("")
        $firstNameFld.val("")

        const newUser = {
            username: 'username',
            first: 'firstName',
            last: 'TBD1',
            role: 'TBD2'
        }

        userService.createUser(newUser)
            .then(actualNewUser => {
                users.push(actualNewUser)
                renderUsers(users)
            })
    }

    const updateSelectedUser = () => {
        const newUsername = $("#usernameFld").val()
        const newFirstName = $("#firstNameFld").val()
        const userId = users[selectedtUserIndex]._id
        userService.updateUser(userId,{
            username: newUsername,
            first: newFirstName
        })
            .then(response=>{
                users[selectedtUserIndex].username = newUsername
                users[selectedtUserIndex].first = newFirstName
                renderUsers(users)
            })
    }


    const main = () => {
        const heading1 = jQuery("h1") //grab element
        heading1
            .css("color", "yellow")
            .css("background-color", "red")
            .html("User administrator")
            .append("- Only for adminstrator")
            .append("<button>OK</button>")

        const container = $(".container")
        $tbody = $("tbody") //grab $tbody
        $userRowTemplate = $("tr.wbdv-template")
        $createBtn = $(".wbdv-create").click(createUser)
        $firstNameFld = $("#firstNameFld")
        $usernameFld = $("#usernameFld")
        $(".wbdv-update").click(updateSelectedUser)
        //$(".wbdv-remove").click(deleteUser)

        userService.findAllUsers()
            .then((_users) => {
                console.log(_users)
                users = _users
                renderUsers(users)
            })

    }
    $(main)

})()