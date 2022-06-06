import React from "react";
import {
  Modal,
  Box,
  Button,
  Grid,
  TextField,
  FormControlLabel,
  Checkbox,
  MenuItem,
  InputLabel,
  Select,
} from "@mui/material";
import { useEffect, useState } from "react";
import modalStyle from "../Constants/Styles";

export default function AddAttractionModal(props) {
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [attractionType, setAttractionType] = useState("BEACH");
  const [nearDestination, setNearDestination] = useState(false);
  const [tickets, setTickets] = useState(false);
  const [childFriendly, setChildFriendly] = useState(false);

  useEffect(() => {}, [props]);

  const closeModal = () => {
    props.close(false);
  };

  const handleAdd = () => {
    props.onAdd({
      name: name,
      description: description,
      nearDestination: nearDestination,
      tickets: tickets,
      childFriendly: childFriendly,
      attractionType: attractionType,
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
          <h2>Add Attraction</h2>
        </Grid>
        <TextField
          margin="normal"
          label="Name"
          placeholder="Enter name"
          fullWidth
          value={name}
          required
          onChange={(e) => {
            setName(e.target.value);
          }}
        ></TextField>
        <TextField
          margin="normal"
          label="Description"
          placeholder="Enter description"
          fullWidth
          value={description}
          required
          onChange={(e) => {
            setDescription(e.target.value);
          }}
        ></TextField>
        <InputLabel id="demo-simple-select-label">Attraction type</InputLabel>
        <Select
          labelId="demo-simple-select-label"
          id="demo-simple-select"
          value={attractionType}
          label="Attraction type"
          onChange={(e) => {
            setAttractionType(e.target.value);
          }}
        >
          <MenuItem value="BEACH">Beach</MenuItem>
          <MenuItem value="NATURE">Nature</MenuItem>
          <MenuItem value="SHOPPING_MALL">Shopping mall</MenuItem>
          <MenuItem value="MUESEM">Museum</MenuItem>
          <MenuItem value="GALERY">Galery</MenuItem>
          <MenuItem value="MONUMENT">Monument</MenuItem>
          <MenuItem value="CLUB">Club</MenuItem>
          <MenuItem value="CONCERT">Concert</MenuItem>
          <MenuItem value="EXTREME_SPORT">Extreme sport</MenuItem>
          <MenuItem value="RESTAURANT">Restaurant</MenuItem>
        </Select>
        <div></div>
        <FormControlLabel
          control={
            <Checkbox
              checked={nearDestination}
              onChange={(e) => {
                setNearDestination(e.target.checked);
              }}
            />
          }
          label="Near destination"
        />
        <FormControlLabel
          control={
            <Checkbox
              checked={tickets}
              onChange={(e) => {
                setTickets(e.target.checked);
              }}
            />
          }
          label="Tickets"
        />
        <FormControlLabel
          control={
            <Checkbox
              checked={childFriendly}
              onChange={(e) => {
                setChildFriendly(e.target.checked);
              }}
            />
          }
          label="Child friendly"
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
