// Mixer
#ifndef MIXER_H
#define MIXER_H

#include <vector>

#include "Channel.h"


namespace ECMS {
	class Mixer {
	private:
		std::vector<ECMS::Channel*> channels;
	public:
		Mixer(int channels);

		std::vector<ECMS::Channel*> getChannels(){
			return channels;
		}
	};
}

#endif