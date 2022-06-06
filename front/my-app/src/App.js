import './App.css';
import {
  BrowserRouter as Router,
  Route,
  Routes,
} from "react-router-dom";
import FormPage from './Components/FormPage'
import LoginPage from './Components/LoginPage';
import Header from './Components/Header';
import Popular from './Components/Popular';
import ForType from './Components/ForType';
import Destinations from './Components/Destinations';
import AttractionsAdmin from './Components/AttractionsAdmin';
import DestinationsAdmin from './Components/DestinationsAdmin';
import ConfigPage from './Components/ConfigPage'

function App() {
  return (
    <Router>
      <div className="App">
        <Routes>
          <Route exact path="/" element={<FormPage></FormPage>}></Route>
          <Route exact path="/login" element={<LoginPage></LoginPage>}></Route>
          <Route exact path="/popular" element={<Popular></Popular>}></Route>
          <Route exact path="/type" element={<ForType></ForType>}></Route>
          <Route exact path="/destinations" element={<Destinations></Destinations>}></Route>
          <Route exact path="/destinationsAdmin" element={<DestinationsAdmin></DestinationsAdmin>}></Route>
          <Route exact path="/config" element={<ConfigPage></ConfigPage>}></Route>
          <Route exact path="/attractionsAdmin" element={<AttractionsAdmin></AttractionsAdmin>}></Route>
        </Routes>
      </div>
    </Router>
  );
}

export default App;
