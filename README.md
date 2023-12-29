# IntentApp

##
#BRIAN BARNABAS LANGAY
2322190027
##


### Project Structure:

1. **MainActivity:**
   - Responsible for sending messages.
   - Contains a RecyclerView to display sent and received messages.
   - Sends messages to MainActivity2 using Intent.

   ```
   // MainActivity code snippet
   ```

2. **MainActivity2:**
   - Responsible for receiving and replying to messages.
   - Contains a RecyclerView to display sent and received messages.
   - Replies to MainActivity using Intent.

   ```
   // MainActivity2 code snippet
   ```

3. **ChatAdapter:**
   - Manages the RecyclerView in both activities.
   - Handles different message types (received or sent).
   - Inflates appropriate layouts for each message type.

   ```
   // ChatAdapter code snippet
   ```

4. **ChatMessage:**
   - Data class to represent a chat message.
   - Contains sender, message content, and message type.

   ```
   // ChatMessage data class code snippet
   ```

### Layouts:

1. **item_sms_received.xml:**
   - Layout for received messages in MainActivity.

   ```xml
   <!-- item_sms_received.xml code snippet -->
   ```

2. **item_sms_sent.xml:**
   - Layout for sent messages in MainActivity.

   ```xml
   <!-- item_sms_sent.xml code snippet -->
   ```

3. **item_sms_received_main2.xml:**
   - Layout for received messages in MainActivity2.

   ```xml
   <!-- item_sms_received_main2.xml code snippet -->
   ```

4. **item_sms_sent_main2.xml:**
   - Layout for sent messages in MainActivity2.

   ```xml
   <!-- item_sms_sent_main2.xml code snippet -->
   ```

### Usage:

1. **Sending Messages from MainActivity:**
   - Collects message input from the user.
   - Uses an Intent to pass the message to MainActivity2.

   ```
   // Sending messages from MainActivity code snippet
   ```

2. **Receiving and Replying in MainActivity2:**
   - Retrieves the message from the Intent.
   - Displays received messages and allows replying.

   ```
   // Receiving and replying in MainActivity2 code snippet
   ```

3. **ChatAdapter Usage:**
   - Initializes the RecyclerView with the ChatAdapter.
   - Adds messages to the adapter.

   ```
   // ChatAdapter usage code snippet
   ```

### Conclusion:

This simple chat application demonstrates basic communication between two activities in Android using Intents. The ChatAdapter efficiently manages the display of messages in RecyclerViews, handling different message types and layouts. The project structure encourages modularity and readability.
