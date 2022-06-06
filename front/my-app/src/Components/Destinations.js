import React from "react";
import Destination from "./Destination";
import { useState, useEffect } from "react";
import { useLocation } from "react-router";
import environment from "../Constants/Environment";
import axios from "axios";
import Attractions from "./Attractions";

export default function Destinations(props) {
  const location = useLocation();
  const [destinations, setDestinations] = useState([]);
  const [attractionsModal, setAttractionsModal] = useState(false);
  const [attractions, setAttractions] = useState([]);

  useEffect(() => {
    console.log(location.state);
    setDestinations(location.state.destinations.destinations)
  }, []);

  const handleAttractions = (id) => {
    axios.post(environment.baseURL+'attraction?destinationId='+id,location.state.parameters).then(response=>{
        console.log(response.data)
        setAttractions(response.data.attractions)
        setAttractionsModal(true)
    });
  };

  return (
    <div style={{marginTop:"20px"}}>
      {destinations.map((dest) => (
        <Destination destination={dest} dblClick={handleAttractions}></Destination>
    ))}
    <Attractions
        close={setAttractionsModal}
        modal={attractionsModal}
        attractions={attractions}
      ></Attractions>
    </div>
  );
}
