

async function postTrip(driverId, carId, origin, destination){
    const response = await fetch("api/trip",{
            method : "POST",
            headers : {"Content-Type" : "application/json"},
            body : JSON.stringify({
                    "driverId" : driverId,
                    "carId" : carId,
                    "destination" : destination,
                    "origin" : origin
            })


    } )
    if (!response.ok) throw new Error("Couldn't add trip");
    return response.json();
}

async function startTrip(tripId){
    const response = await fetch("/api/trip/start/" + tripId,{
        method : "POST"
    })
    if (!response.ok) throw new Error("Couldn't start trip");
}

async function endTrip(tripId){
    const response = await fetch("/api/trip/end/" + tripId,{
        method : "POST"
    })
    if(!response.ok) throw new Error("Couldn't end trip")
}

async function getDrivers(){
    const response = await fetch("/api/driver",
    )
    if(!response.ok){
        throw new Error('Could not fetch driver');
    }
    return response.json();
}

async function getCars(){
    const response = await fetch("/api/car");
    if(!response.ok)
        throw new Error('Could not fetch car');
    return response.json();
}

async function getTrips(){
    const response = await fetch("/api/trip");
    if(!response.ok)
        throw new Error('Could not fetch trips');
    return response.json();
}

async function getTripsByOrder(){
    const response = await fetch("/api/trip/order");
    if(!response.ok)
        throw new Error('Could not fetch trips');
    return response.json();
}

