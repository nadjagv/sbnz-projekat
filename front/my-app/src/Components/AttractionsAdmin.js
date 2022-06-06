import React from "react";
import Header from "./Header";
import { useEffect, useState } from "react";
import { useLocation } from "react-router";
import environment from "../Constants/Environment";
import axios from "axios";
import Attraction from "./Attraction";
import AddAttractionModal from "./AddAttractionModal";
import { Button } from "@mui/material";

export default function AttractionsAdmin() {
  const location = useLocation();
  const [addAttractionModal, setAddAttractionModal] = useState(false);
  const [attractions, setAttractions] = useState([]);

  const addAttraction=(attraction)=>{
    axios.post(environment.baseURL + "attraction",{...attraction,destinationId:location.state.destinationId}).then(response=>{
      //const atrs=[...attractions,{...attraction,destinationId:location.state.destinationId}]
      //setAttractions(atrs)
      window.location.reload()
    })
  }

  useEffect(() => {
    console.log(location.state);
    axios
      .get(
        environment.baseURL +
          "attraction/destination/" +
          location.state.destinationId
      )
      .then((response) => {
        setAttractions(response.data);
      });
  }, []);

  const handleDelete = (attractionId) => {
    axios
      .delete(environment.baseURL + "attraction/" + attractionId)
      .then((response) => {
        const atrs = attractions.filter((a) => a.id != attractionId);
        setAttractions(atrs);
      });
  };

  const handleAdd = () => {
    setAddAttractionModal(true);
  };

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
        Add Attraction
      </Button>
      {attractions.map((attr) => (
        <Attraction attr={attr} onDelete={handleDelete}></Attraction>
      ))}
      <AddAttractionModal
        close={setAddAttractionModal}
        modal={addAttractionModal}
        onAdd={addAttraction}
      ></AddAttractionModal>
    </>
  );
}
