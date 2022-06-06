import React from "react";
import {
  Modal,
  Box,
  Button,
  Grid,
  TextField,
  FormLabel,
  Radio,
  RadioGroup,
  FormControlLabel,
  Checkbox,
} from "@mui/material";
import { useEffect, useState } from "react";
import modalStyle from "../Constants/Styles";

export default function AddDestinationModal(props) {
  const [loc, setLoc] = useState("");
  const [destinationType, setDestinationType] = useState("YOUNGER");
  const [budgetCategory, setBudgetCategory] = useState("BUDGET");
  const [townProximity, setTownProximity] = useState("TOWN");
  const [airport, setAirport] = useState(false);
  const [rentACar, setRentACar] = useState(false);
  const [beach, setBeach] = useState(false);
  const [sightseeings, setSightseeings] = useState(false);
  const [shops, setShops] = useState(false);
  const [restaurants, setRestaurants] = useState(false);
  const [childrenActivities, setChildrenActivities] = useState(false);

  useEffect(() => {}, [props]);

  const closeModal = () => {
    props.close(false);
  };

  const handleAdd = () => {
    props.onAdd({
      location: loc,
      price: budgetCategory,
      destinationType: destinationType,
      proximity: townProximity,
      airport: airport,
      rentACar: rentACar,
      beach: beach,
      sightseeings: sightseeings,
      shops: shops,
      restaurants: restaurants,
      childrenActivities: childrenActivities,
    });
    props.close(false);
  };

  const btnstyle = { margin: "8px 0", margin: "auto" };
  return (
    <Modal
      open={props.modal}
      onClose={() => {
        closeModal();
      }}
      aria-labelledby="modal-modal-title"
      aria-describedby="modal-modal-description"
    >
      <Box sx={modalStyle}>
        <Grid>
          <h2>Add Destination</h2>
        </Grid>
        <TextField
          margin="normal"
          label="Location"
          placeholder="Enter location"
          fullWidth
          value={loc}
          required
          onChange={(e) => {
            setLoc(e.target.value);
          }}
        ></TextField>
        <FormLabel id="demo-row-radio-buttons-group-label">
          Destination Type
        </FormLabel>
        <RadioGroup
          aria-labelledby="demo-radio-buttons-group-label"
          name="radio-buttons-group"
          value={destinationType}
          onChange={(e) => {
            setDestinationType(e.target.value);
          }}
          row
        >
          <FormControlLabel
            value="YOUNGER"
            control={<Radio />}
            label="Younger"
          />
          <FormControlLabel
            value="COUPLES"
            control={<Radio />}
            label="Couples"
          />
          <FormControlLabel value="SINGLE" control={<Radio />} label="Single" />
          <FormControlLabel value="FAMILY" control={<Radio />} label="Family" />
          <FormControlLabel value="OLDER" control={<Radio />} label="Older" />
        </RadioGroup>
        <FormLabel id="demo-row-radio-buttons-group-label">
          Budget Category
        </FormLabel>
        <RadioGroup
          aria-labelledby="demo-radio-buttons-group-label"
          name="radio-buttons-group"
          value={budgetCategory}
          onChange={(e) => {
            setBudgetCategory(e.target.value);
          }}
          row
        >
          <FormControlLabel value="BUDGET" control={<Radio />} label="Budget" />
          <FormControlLabel
            value="STANDARD"
            control={<Radio />}
            label="Standard"
          />
          <FormControlLabel value="LUX" control={<Radio />} label="Lux" />
        </RadioGroup>
        <FormLabel id="demo-row-radio-buttons-group-label">
          Town Proximity
        </FormLabel>
        <RadioGroup
          aria-labelledby="demo-radio-buttons-group-label"
          name="radio-buttons-group"
          value={townProximity}
          onChange={(e) => {
            setTownProximity(e.target.value);
          }}
          row
        >
          <FormControlLabel value="TOWN" control={<Radio />} label="Town" />
          <FormControlLabel value="SUBURB" control={<Radio />} label="Suburb" />
          <FormControlLabel
            value="WILDERNESS"
            control={<Radio />}
            label="Wilderness"
          />
        </RadioGroup>
        <FormControlLabel
          control={
            <Checkbox
              checked={airport}
              onChange={(e) => {
                setAirport(e.target.checked);
              }}
            />
          }
          label="Airport"
        />
        <FormControlLabel
          control={
            <Checkbox
              inputProps={{ "aria-label": "controlled" }}
              checked={rentACar}
              onChange={(e) => {
                setRentACar(e.target.checked);
              }}
            />
          }
          label="Rent a Car"
        />
        <FormControlLabel
          control={
            <Checkbox
              inputProps={{ "aria-label": "controlled" }}
              checked={beach}
              onChange={(e) => {
                setBeach(e.target.checked);
              }}
            />
          }
          label="Beach"
        />
        <FormControlLabel
          control={
            <Checkbox
              inputProps={{ "aria-label": "controlled" }}
              checked={sightseeings}
              onChange={(e) => {
                setSightseeings(e.target.checked);
              }}
            />
          }
          label="Sightseeings"
        />
        <FormControlLabel
          control={
            <Checkbox
              inputProps={{ "aria-label": "controlled" }}
              checked={shops}
              onChange={(e) => {
                setShops(e.target.checked);
              }}
            />
          }
          label="Shops"
        />
        <FormControlLabel
          control={
            <Checkbox
              inputProps={{ "aria-label": "controlled" }}
              checked={restaurants}
              onChange={(e) => {
                setRestaurants(e.target.checked);
              }}
            />
          }
          label="Restaurants"
        />
        <FormControlLabel
          control={
            <Checkbox
              inputProps={{ "aria-label": "controlled" }}
              checked={childrenActivities}
              onChange={(e) => {
                setChildrenActivities(e.target.checked);
              }}
            />
          }
          label="Children Activities"
        />
        <div></div>
        <Button
          type="submit"
          color="success"
          variant="contained"
          style={btnstyle}
          onClick={() => {
            handleAdd();
          }}
        >
          Add
        </Button>
      </Box>
    </Modal>
  );
}
