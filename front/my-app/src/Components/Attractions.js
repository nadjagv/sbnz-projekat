import {
  Modal,
  Box,
  Typography,
  Stack,
  Card,
  CardHeader,
  IconButton,
  CardMedia,
  CardContent,
  CardActions,
  Collapse,
  Rating,
} from "@mui/material";
import React from "react";
import { useState, useEffect } from "react";
import axios from "axios";
import environment from "../Constants/Environment";
import modalStyle from "../Constants/Styles";
import { red } from "@mui/material/colors";
import FavoriteIcon from "@mui/icons-material/Favorite";
import ShareIcon from "@mui/icons-material/Share";
import ExpandMoreIcon from "@mui/icons-material/ExpandMore";
import MoreVertIcon from "@mui/icons-material/MoreVert";
import CheckIcon from '@mui/icons-material/Check';
import CloseIcon from '@mui/icons-material/Close';
import { styled } from "@mui/material/styles";

const ExpandMore = styled((props) => {
  const { expand, ...other } = props;
  return <IconButton {...other} />;
})(({ theme, expand }) => ({
  transform: !expand ? "rotate(0deg)" : "rotate(180deg)",
  marginLeft: "auto",
  transition: theme.transitions.create("transform", {
    duration: theme.transitions.duration.shortest,
  }),
}));

function Attractions(props) {
  const [expanded, setExpanded] = useState(false);

  const handleExpandClick = () => {
    setExpanded(!expanded);
  };
  useEffect(() => {
  }, [props]);
  const closeModal = () => {
    props.close(false);
  };
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
        <Typography id="modal-modal-title" variant="h6" component="h2">
          Attractions
        </Typography>
        {props.attractions.map((attr) => (
          <Card
            sx={{ maxWidth: 345, margin: 10 }}
            style={{ border: "1px solid grey" }}
          >
            <CardHeader title={attr.name} />
            <CardMedia component="img" height="194" image="" alt="Missing..." />
            <CardContent>
              <Typography variant="body1">Tickets:{attr.tickets ? <CheckIcon></CheckIcon> : <CloseIcon></CloseIcon>}</Typography>
              <Typography variant="body1">Child friendly:{attr.childFriendly ? <CheckIcon></CheckIcon> : <CloseIcon></CloseIcon>}</Typography>
              <Typography variant="body1">Close to town:{attr.nearDestination ? <CheckIcon></CheckIcon> : <CloseIcon></CloseIcon>}</Typography>
              <Typography variant="body2" color="text.secondary">
                {attr.description}
              </Typography>
            </CardContent>
            <CardActions disableSpacing>
              <ExpandMore
                expand={expanded}
                onClick={handleExpandClick}
                aria-expanded={expanded}
                aria-label="show more"
              >
                <ExpandMoreIcon />
              </ExpandMore>
            </CardActions>
            <Collapse in={expanded} timeout="auto" unmountOnExit>
              <CardContent>
                <Typography paragraph>Review:</Typography>
                {attr.reviews.map((rev)=>(
                    <div><Typography component="legend">{rev.date}</Typography><Rating name="read-only" value={rev.rating} readOnly /></div>
                ))}
              </CardContent>
            </Collapse>
          </Card>
        ))}
        <Stack spacing="3" alignItems="center"></Stack>
      </Box>
    </Modal>
  );
}
export default Attractions;
