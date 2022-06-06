import React from "react";
import { InputLabel, Select, MenuItem, Button } from "@mui/material";
import axios from "axios";
import { useState, useEffect } from "react";
import environment from "../Constants/Environment";
import Destination from "./Destination";
import Header from './Header'

export default function ForType() {
  const [aType, setAType] = useState("YOUNGER");
  const [destinations, setDestinations] = useState([]);

  const btnstyle = { margin: "8px 0", width: "30px" };

  const handleSearch = () => {
    axios
      .get(environment.baseURL + "query/type?dt=" + aType)
      .then((response) => {
        console.log(response.data);
        setDestinations(response.data);
      });
  };

  return (
    <><Header></Header><div>
      <InputLabel id="demo-simple-select-label">Type to Search</InputLabel>
      <Select
        labelId="demo-simple-select-label"
        id="demo-simple-select"
        value={aType}
        label="Travelling with"
        onChange={(e) => {
          setAType(e.target.value);
        }}
      >
        <MenuItem value="YOUNGER">Younger</MenuItem>
        <MenuItem value="COUPLES">Couples</MenuItem>
        <MenuItem value="SINGLE">Single</MenuItem>
        <MenuItem value="FAMILY">Family</MenuItem>
        <MenuItem value="OLDER">Older</MenuItem>
      </Select>
      <div>
        <Button
          type="submit"
          color="primary"
          variant="contained"
          style={btnstyle}
          fullWidth
          onClick={() => {
            handleSearch();
          }}
        >
          Search
        </Button>
      </div>
      {destinations.map((dest) => (
        <Destination destination={dest}></Destination>
      ))}
    </div></>
  );
}
