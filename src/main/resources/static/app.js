

const driverList = document.getElementById("driver-list");
const carList  =document.getElementById("car-list");
const driverSelect = document.getElementById("driver-select")
const carSelect = document.getElementById("car-select");
const origin = document.getElementById("origin");
const destination = document.getElementById("destination");
const tripForm = document.getElementById("trip-form");
const tripTable = document.getElementById("trip-table-body");






function addDriver(driver){
    const option = document.createElement("option");
    option.className = "fleet-option";
    option.label = driver.name;
    option.value = driver.id;
    console.log(option);
    driverSelect.append(option);
}

function addCar(car){
    const option = document.createElement("option");
    option.className = "fleet-option-car";
    option.label = car.referenceName;
    option.value = car.id;
    carSelect.append(option);

}




async function init() {
    const driver = await getDrivers();
    const carr = await  getCars();
    const trips = await getTrips();
    console.log(driver);
    showDrivers(driver);
    console.log(carr);
    showCars(carr);
    console.log(trips);
    showTrips(trips);



}


init();