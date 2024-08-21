#!/bin/bash

# Load variables from .env file
if [ -f .env ]; then
  export $(cat .env | xargs)
else
  echo ".env file not found!"
  exit 1
fi

echo "Logging in to Azure..."
az login

# Set the subscription
if [ ! -z "$SUBSCRIPTION_ID" ]; then
  echo "Setting the subscription..."
  az account set --subscription "$SUBSCRIPTION_ID"
fi

# Deploy the JAR file
echo "Deploying JAR file to existing WebApp..."
az webapp deploy --resource-group $RESOURCE_GROUP --name $WEBAPP_NAME --src-path "$JAR_FILE_PATH" --type war

# Output the WebApp URL
echo "Deployment complete. Application is live at:"
echo "https://$WEBAPP_NAME.azurewebsites.net"
