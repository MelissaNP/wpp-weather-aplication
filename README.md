## API Documentation

The API provides a single endpoint `/whatsapp` to handle incoming messages from WhatsApp. The message body should contain the location for which the weather report is requested.

### Example Request:

- **Method:** `POST`
- **Content-Type:** `application/x-www-form-urlencoded`
- **Body Parameters:**
    - `From`: The sender's WhatsApp number.
    - `Body`: The location name.

### Example Response:

- A WhatsApp message with the current weather information for the provided location.

## Demonstration

You can see the application in action by messaging the Twilio number connected to this service with a location, such as "São Carlos."

[Watch the demo video](Assets/Screen_Recording_20240825_190303_WhatsApp.mp4)
## Authors

- **Melissa Pereira** - [GitHub Profile](https://github.com/melissapereira)
