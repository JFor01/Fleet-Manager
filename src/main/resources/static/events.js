

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
