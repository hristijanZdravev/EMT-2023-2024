import axios from '../custom-axios/axios';

const HousingService = {
    fetchHousing: () => {
        return axios.get("/housing");
    },

    fetchHost: () => {
        return axios.get("/host");
    },

    fetchHousingCatagories: () => {
    return axios.get("/housing/categories");
    },

    getHousing: (id) => {
        return axios.get(`/housing/${id}`);
    },

    addHousing: (name, category, hostId, numRooms) => {
        return axios.post("/housing/add", {
            "name": name,
            "category": category,
            "hostId": hostId,
            "numRooms": numRooms
        });
    },

    editHousing: (id, name, category, hostId, numRooms) => {
        return axios.put(`/housing/edit/${id}`, {
            "name": name,
            "category": category,
            "hostId": hostId,
            "numRooms": numRooms
        });
    },

    deleteHousing: (id) => {
        return axios.delete(`/housing/delete/${id}`);
      },

      rentHousing: (id) => {
        return axios.put(`/housing/rent/${id}`);
      }

      



}

export default HousingService;

