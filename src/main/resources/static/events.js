

 tripForm.addEventListener("submit",
    async (event) => {
        event.preventDefault();
        const driverId = Number(driverSelect.value);
        const carId = Number(carSelect.value);
        const from = origin.value;
        const to = destination.value;

        console.log(driverId,carId,from,to);
        const response = await postTrip(driverId,carId,from,to);
        console.log(response);
        showTrips(response);

    }

    )




 tripTable.addEventListener("click",
     async (event) => {
        const button = event.target.closest("button[data-trip-id]")
         if(!button) return;

         await handleButton(button);
         const trips = await getTripsByOrder();
         tripTableBody.replaceChildren();
         showTrips(trips);
         driverList.replaceChildren();
         const drivers = await getDrivers();
         showDrivers(drivers);
         carList.replaceChildren();
         const cars = await getCars();
         showCars(cars);
         driverSelect.replaceChildren();
         carSelect.replaceChildren();
         addDrivers(drivers);
         addCars(cars);

     }

     )
