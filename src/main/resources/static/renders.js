function showDrivers(drivers) {
    let counter = 0;
    for (const driver of drivers){
        console.log(driverList);
        const li = document.createElement("li");
        li.className = "fleet-item";

        const name = document.createElement("span");
        name.textContent = driver.name;
        const age = document.createElement("span")
        age.textContent = driver.age;
        li.append(name, age)
        driverList.append(li);
        addDriver(driver);
        counter++;
    }
    if (counter>0){
        document.getElementById("driver-empty").hidden = true;
    }
}

function showCars(cars){
    let counter = 0;
    for (const car of cars) {
        console.log(carList)
        const li_car = document.createElement("li");
        li_car.className = "fleet-item"
        const name = document.createElement("span");
        name.textContent = car.referenceName;
        const brandName = document.createElement("span");
        brandName.textContent = car.brand;

        li_car.append(name, brandName);

        carList.append(li_car);
        addCar(car);
        counter ++;
    }
    if (counter > 0){
        document.getElementById("car-empty").hidden = true;
    }

}


function showTrips(trips){
    const items = Array.isArray(trips) ? trips : [trips]
    let counter = 0;
    for(const trip of items){
        const tableRow = document.createElement("tr");
        tableRow.className = "fleet-table-row"
        tableRow.insertCell().textContent = trip.driver.name
        tableRow.insertCell().textContent = trip.car.referenceName;
        tableRow.insertCell().textContent = trip.origin;
        tableRow.insertCell().textContent = trip.destination;
        tableRow.insertCell().textContent = trip.status;
        tripTable.prepend(tableRow);

    }
}