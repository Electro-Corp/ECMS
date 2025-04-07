// Channel
#ifndef CHANNEL_H
#define CHANNEL_H

namespace ECMS {
	class Channel {
	private:
		int id;
	public:
		Channel(int id);

		int getId() {
			return id;
		}
	};
}

#endif