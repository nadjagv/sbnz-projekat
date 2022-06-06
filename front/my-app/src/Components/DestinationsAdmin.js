import React from "react";
import { useEffect, useState } from "react";
import Header from "./Header";
import axios from "axios";
import environment from "../Constants/Environment";
import Destination from "./Destination";
import { Button } from "@mui/material";
import AddDestinationModal from "./AddDestinationModal";
import { useNavigate } from "react-router";

export default function DestinationsAdmin() {
  const [destinations, setDestinations] = useState([]);
  const [addDestinationModal, setAddDestinationModal] = useState(false);
  const navigate = useNavigate();

  useEffect(() => {
    axios.get(environment.baseURL + "destination").then((response) => {
      setDestinations(response.data);
    });
  }, []);

  const handleDelete = (destinationId) => {
    axios.delete(environment.baseURL + "destination/"+destinationId).then(response=>{
      const dest=destinations.filter(d=>d.id!=destinationId)
      setDestinations(dest)
    })
  };

  const handleAdd = () => {
    setAddDestinationModal(true);
  };

  const handleShowAttractions=(destinationId)=>{
    navigate('/attractionsAdmin',{state:{destinationId:destinationId}});
  }

  const addDestination=(destination)=>{
    console.log(destination)
    axios.post(environment.baseURL + "destination",destination).then(response=>{
      const dest=[...destinations,destination]
      setDestinations(dest)
    })
  }

  const btnstyle = { margin: "8px 0" };

  return (
    <>
      <Header></Header>
      <Button
        type="submit"
        color="success"
        variant="contained"
        style={btnstyle}
        onClick={() => {
          handleAdd();
        }}
      >
        Add Destination
      </Button>
      {destinations.map((dest) => (
        <Destination
          destination={dest}
          dblClick={handleShowAttractions}
          onDelete={handleDelete}
        ></Destination>
      ))}
      <AddDestinationModal
        close={setAddDestinationModal}
        modal={addDestinationModal}
        onAdd={addDestination}
      ></AddDestinationModal>
    </>
  );
}
