

const driverList = document.getElementById("driver-list");
const carList  =document.getElementById("car-list");
const driverSelect = document.getElementById("driver-select")
const carSelect = document.getElementById("car-select");
const origin = document.getElementById("origin");
const destination = document.getElementById("destination");
const tripForm = document.getElementById("trip-form");
const tripTable = document.getElementById("trip-table-body");
const tripTableBody = document.getElementById("trip-table-body");





function addDrivers(drivers){
    const items = Array.isArray(drivers) ? drivers : [drivers]
    for(const driver of items) {
        const option = document.createElement("option");
        option.className = "fleet-option";
        console.log(driver);
        driver.active === true ? option.hidden = true : option.hidden = false;
        option.label = driver.name;
        option.value = driver.id;
        console.log(option);
        driverSelect.append(option);
    }
}

function addCars(cars){
    const item = Array.isArray(cars) ? cars : [cars];
    for(const car of item) {
        const option = document.createElement("option");
        option.className = "fleet-option-car";
        option.id = "fleet-option-car" + car.id;
        car.inUse === true ? option.hidden = true : option.hidden = false;
        option.label = car.referenceName;
        option.value = car.id;
        carSelect.append(option);
    }

}

function hideDriver(id){
    const option = document.getElementById("fleet-option"+ id);
    option.hidden = true;
}

function displayDriver(id){
    const option = document.getElementById("fleet-option-car" + id);
    option.hidden = true;
}

async function handleButton(button){
    if (button.dataset.state === "COMMENCING"){
        try {
            await startTrip(button.dataset.tripId);
            button.dataset.state = "ACTIVE";
        }
        catch (error){
            alert(error.message);
        }
    }
    else if(button.dataset.state === "ACTIVE"){
        await endTrip(button.dataset.tripId);
        button.dataset.state = " FINISHED";
    }
}




async function init() {
    const drivers = await getDrivers();
    const cars = await  getCars();
    const trips = await getTripsByOrder();
    console.log(drivers);
    showDrivers(drivers);
    addDrivers(drivers);
    console.log(cars);
    showCars(cars);
    addCars(cars);
    console.log(trips);
    showTrips(trips);



}


init();