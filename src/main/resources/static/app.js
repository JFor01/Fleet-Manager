

const driverList = document.getElementById("driver-list")

async function getDrivers(){
    const response = await fetch("/api/driver/552",
        )
    if(!response.ok){
        throw new Error('Could not fetch driver');
    }
    return response.json();
}

function showDrivers(){
    const response = getDrivers();
    console.log(response);
}

async function init() {
    showDrivers();

}


init();