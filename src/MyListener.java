import javax.jms.*;

class MyListener {
    void listen(String text) {
        ConnectionFactory connectionFactory = new ConnectionFactory() {
            @Override
            public Connection createConnection() {
                return null;
            }

            @Override
            public Connection createConnection(String s, String s1) {
                return null;
            }
        };

        Queue queue = () -> null;

        final int NUM_MSGS = 10;

        try {
            JMSContext context = (JMSContext) connectionFactory.createConnection();
            System.out.println("\nPassing To Queue\n\n " + text);
            if (context != null) {
                context.createProducer().send(queue, text);
            }
//            for (int i = 0; i < NUM_MSGS; i++) {
//                text = "This is message " + (i + 1);
//                System.out.println("Sending message: " + text);
//                if (context != null) {
//                    context.createProducer().send(queue, text);
//                }
//            }
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}