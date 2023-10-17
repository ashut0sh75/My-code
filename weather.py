import requests

# Prompt the user to enter a city name
city = input("Enter the name of a city: ")

# Replace the placeholder value with your actual API key
API_KEY = "2606f769271b8d545fe3458b2b72ed9f"

# Construct the URL with the city name and API key
url = f"http://api.openweathermap.org/data/2.5/weather?q={city}&appid={API_KEY}"

try:
    # Send the GET request to the API
    response = requests.get(url)
    data = response.json()

    # Check if the response status code indicates success (200)
    if response.status_code == 200:
        # Extract relevant information from the response
        temperature = data['main']['temp']
        humidity = data['main']['humidity']
        description = data['weather'][0]['description']
        wind_speed = data['wind']['speed']
        visibility = data['visibility']

        # Display the weather information to the user
        print(f"Weather information for {city}:")
        print(f"Temperature: {temperature} K")
        print(f"Humidity: {humidity}%")
        print(f"Description: {description}")
        print(f"Wind Speed: {wind_speed} m/s")
        print(f"Visibility: {visibility} meters")
    else:
        print(f"City not found. Please check the city name or try a different one.")

except requests.exceptions.RequestException as e:
    print("An error occurred while fetching the weather data.")
