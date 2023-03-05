const axios = require('axios');

    const javaApi = axios.create({
        baseURL: "http://localhost:8080"
    })

export {
    javaApi
}